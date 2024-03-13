package br.com.maddytec.cliente.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("cliente")
public class ClientRedis {

    @Id
    @Indexed
    private String cpf;
    private String nome;
    private String email;
}
