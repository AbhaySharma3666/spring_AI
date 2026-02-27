package com.spring.ai.service;

import com.spring.ai.entity.Tut;

import java.util.List;

public interface ChatService {

    List<Tut> chat(String query);
}
