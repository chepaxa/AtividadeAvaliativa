package com.atividade.br.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade.br.domain.Social;

@Repository
public interface SocialRepository extends JpaRepository<Social, Integer> {

}
