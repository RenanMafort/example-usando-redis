package br.com.maddytec.cliente.repository;

import br.com.maddytec.cliente.entity.ClientRedis;
import org.springframework.data.repository.CrudRepository;

public interface ClientRedisRepository extends CrudRepository<ClientRedis,String> {
}
