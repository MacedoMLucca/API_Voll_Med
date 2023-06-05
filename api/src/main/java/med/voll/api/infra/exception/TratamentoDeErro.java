package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.FieldResult;
import med.voll.api.domain.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratamentoDeErro {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity TratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacao::new).toList());
    }

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity TratarErroRegraDeNegocio(ValidacaoException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    public record DadosErrosValidacao(String campo, String mensagem){
        public DadosErrosValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage().toUpperCase());
        }
    }
}
