package br.com.maddytec.cliente.http.controller;

import br.com.maddytec.cliente.entity.ClientRedis;
import br.com.maddytec.cliente.service.ClientRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v2/cliente")
public class ClientRedisController {

    @Autowired
    private ClientRedisService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ClientRedis save(@RequestBody ClientRedis redis){
        return this.service.salvar(redis);
    }

    @GetMapping
    @ResponseBody
    public Iterable<ClientRedis> findAll(){
        return this.service.findAll();
    }
}
