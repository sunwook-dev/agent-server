package com.example.agent_server;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AppController {
    
    private BoardRepository boardRepository;

    public AppController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/home")
    public String home() {
        return "agent Action!!";
    }

    @GetMapping("/boards")
    public ResponseEntity<List<Board>> getBoards() {
        Board board = new Board("agent 제목", "agent 내용");
        boardRepository.save(board);

        List<Board> boards = boardRepository.findAll();
        return ResponseEntity.ok().body(boards);
    }    
}
