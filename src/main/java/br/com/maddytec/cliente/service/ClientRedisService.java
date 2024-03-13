package br.com.maddytec.cliente.service;

import br.com.maddytec.cliente.entity.ClientRedis;
import br.com.maddytec.cliente.entity.Cliente;
import br.com.maddytec.cliente.repository.ClientRedisRepository;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@Log4j2
public class ClientRedisService {

    private  final long MINUTO = 1000 * 60;
    private  final long MINUTOS = MINUTO * 1;
    @Autowired
    private ClientRedisRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteService service;

    public ClientRedis salvar(ClientRedis cliente){
        return clienteRepository.save(cliente);
    }

    public Iterable<ClientRedis> findAll(){
        return clienteRepository.findAll();
    }

    @Scheduled(fixedDelay = MINUTOS)
    public void sincronizarClienteComBancoDeDados(){
                Iterable<ClientRedis> all = findAll();

        if (!all.iterator().hasNext()){
            log.info("LISTA VAZIA");
        }else {
            all.forEach(c -> {
                log.info(c);
                service.salvar(modelMapper.map(c, Cliente.class));
            });
            clienteRepository.deleteAll();
        }
    }
}
