package ch.stoyanov.martin.task_manager.boards;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ch.stoyanov.martin.task_manager.security.Roles;
import io.micrometer.common.lang.NonNull;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "bearerAuth")
@Validated

public class BoardController {

    private final BoardService boardService;

    BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    
    @GetMapping("api/boards")
    @RolesAllowed(Roles.Read)
    public ResponseEntity<List<Board>> all() {
        List<Board> result = boardService.getBoards();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/boards/{id}")
    public ResponseEntity<Board> one(@PathVariable Long id) {
        Board board = boardService.getBoard(id);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }
    
    @PostMapping("api/boards")
    @RolesAllowed(Roles.Manager)
    public ResponseEntity<Board> newBoard(@Valid @RequestBody @NonNull Board board) {
        Board savedBoard = boardService.insertBoard(board);
        return new ResponseEntity<>(savedBoard, HttpStatus.OK);
    }

    @PutMapping("api/boards/{id}")
    public ResponseEntity<Board> updateBoard(@Valid @RequestBody @NonNull Board board, @PathVariable @NonNull Long id) {
        Board savedBoard = boardService.updateBoard(board, id);
        return new ResponseEntity<>(savedBoard, HttpStatus.OK);
    }

    @DeleteMapping("api/boards/{id}")
    public void deleteBoard(@PathVariable @NonNull Long id) {
        boardService.deleteBoard(id);
    }

}
