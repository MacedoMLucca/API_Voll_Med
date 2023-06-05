package med.voll.api.domain.consulta;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByIdAndAtivoTrue(Long id);

    boolean existsByPacienteIdAndDataBetweenAndAtivoTrue(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    boolean existsByMedicoIdAndDataAndAtivoTrue(Long idMedico, LocalDateTime data);

    Page<Consulta> findAllByAtivoTrue(Pageable paginacao);


}
