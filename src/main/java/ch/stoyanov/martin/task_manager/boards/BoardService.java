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

    public Board getBoard(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(id, Board.class));
    }

    public Board insertBoard(Board board) {
        return repository.save(board);
    }

    public Board updateBoard(Board board, Long id) {
        return repository.findById(id)
            .map(boardOrig -> {
                boardOrig.setTitle(boardOrig.getTitle());
                return repository.save(boardOrig);
            })
            .orElseGet (() -> repository.save(board));
    }

    public void deleteBoard(Long id) {
        repository.deleteById(id);
    }

}