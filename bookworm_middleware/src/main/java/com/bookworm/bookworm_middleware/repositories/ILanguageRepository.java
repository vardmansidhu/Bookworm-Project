import org.springframework.data.jpa.repository.JpaRepository;
import com.bookworm.bookworm_middleware.entities.Language;

public interface ILanguageRepository extends JpaRepository<Language, Integer> {

}