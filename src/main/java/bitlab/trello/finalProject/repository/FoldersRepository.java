package bitlab.trello.finalProject.repository;

import bitlab.trello.finalProject.model.Folders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRepository  extends JpaRepository<Folders, Long> {
}
