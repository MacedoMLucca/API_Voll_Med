package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroPaciente(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "Email é Obrigatorio")
        @Email(message = "Email Invalido")
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}
