package com.fernandes.ToolsChallenge.adapters.out.repository;

import com.fernandes.ToolsChallenge.adapters.out.repository.entity.TransacaoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends MongoRepository<TransacaoEntity, String> {
}
