package bitlab.trello.finalProject.repository;

import bitlab.trello.finalProject.model.Folders;
import bitlab.trello.finalProject.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findByFolders(Folders folders);
}
