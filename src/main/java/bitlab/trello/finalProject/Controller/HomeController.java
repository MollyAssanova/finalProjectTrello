package bitlab.trello.finalProject.Controller;


import bitlab.trello.finalProject.model.Folders;
import bitlab.trello.finalProject.model.TaskCategories;
import bitlab.trello.finalProject.model.Tasks;
import bitlab.trello.finalProject.repository.CommentsRepository;
import bitlab.trello.finalProject.repository.FoldersRepository;
import bitlab.trello.finalProject.repository.TaskCategoriesRepository;
import bitlab.trello.finalProject.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @Autowired
    private FoldersRepository foldersRepository;

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Folders> folders = foldersRepository.findAll();
        model.addAttribute("folders", folders);
        return "index";
    }

    @PostMapping(value = "/add-folder")
    public String addFolder(Folders folders){
        foldersRepository.save(folders);
        return "redirect:/";
    }
    @GetMapping(value = "/addpage")
    public String addPage(){
        return "addpage";
    }

    @GetMapping(value = "/addtaskpage")
    public String addTaskPage(){
        return "addtask";
    }
    @PostMapping(value = "/add-task")
    public String addTask(Tasks tasks){
        tasksRepository.save(tasks);
        return "redirect:/";
    }

    @GetMapping(value = "/folder-details")
    public String folderDetails(@RequestParam(name = "id") Long id, Model model) {
        Folders folder = foldersRepository.findById(id).orElse(null);
        List<Tasks> tasks = tasksRepository.findByFolders(folder);
        model.addAttribute("folder", folder);
        model.addAttribute("tasks", tasks);
        return "folderdetails";
    }
    @GetMapping(value = "/addcatpage")
    public String AddCatPage(){
        return "addcatpage";
    }

    @PostMapping(value = "/add-category")
    public String addCategory(TaskCategories taskCategory) {
        taskCategoriesRepository.save(taskCategory);
        return "redirect:/";
    }

    @GetMapping(value = "/delete-category")
    public String deleteCategory(@RequestParam(name = "id") Long id) {
        taskCategoriesRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping(value = "/delete-task")
    public String deleteTask(@RequestParam(name = "id") Long id) {
        tasksRepository.deleteById(id);
        return "redirect:/";
    }



}


