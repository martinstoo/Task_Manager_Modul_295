package ch.stoyanov.martin.task_manager.boards;

import org.springframework.stereotype.Service;

import ch.stoyanov.martin.task_manager.EntityNotFoundException;

import java.util.List;

@Service
public class BoardService {
    
    private final BoardRepository repository;

    public BoardService(BoardRepository repository) {
        this.repository = repository;
    }

    public List<Board> getBoards() {
        return repository.findByOrderByTitleAsc();
    }

    public Board getBoard(Long board_id) {
        return repository.findById(board_id)
        .orElseThrow(() -> new EntityNotFoundException(board_id, Board.class));
    }

    public Board insertBoard(Board board) {
        return repository.save(board);
    }

    public Board updateBoard(Board board, Long board_id) {
        return repository.findById(board_id)
            .map(boardOrig -> {
                boardOrig.setTitle(boardOrig.getTitle());
                return repository.save(boardOrig);
            })
            .orElseGet (() -> repository.save(board));
    }

    public void deleteBoard(Long board_id) {
        repository.deleteById(board_id);
    }

}