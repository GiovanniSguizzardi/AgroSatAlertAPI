package giovanni_565123.agrosatalert.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import giovanni_565123.agrosatalert.dto.AlertaClimaticoDTO;
import giovanni_565123.agrosatalert.service.AlertaClimaticoService;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaClimaticoController {

    @Autowired
    private AlertaClimaticoService service;

    @GetMapping
    public ResponseEntity<List<AlertaClimaticoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaClimaticoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/talhao/{talhaoId}")
    public ResponseEntity<List<AlertaClimaticoDTO>> findByTalhaoId(@PathVariable Long talhaoId) {
        return ResponseEntity.ok(service.findByTalhaoId(talhaoId));
    }

    @PostMapping
    public ResponseEntity<AlertaClimaticoDTO> save(@RequestBody @Valid AlertaClimaticoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaClimaticoDTO> update(@PathVariable Long id,
            @RequestBody @Valid AlertaClimaticoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}