import java.util.Comparator;
import java.util.concurrent.Callable;

public class Task<E>
{
    public TaskType taskType; // enum Object that defines the priority of the task.
    public static final int DEFAULTPRIORITY = 3; // Default Type of Task (other).
    public Comparator<E> c;
    public Thread thread; // Runs the task.
    public int priority = thread.getPriority();

    public Task(Callable<E> c) {
            this.taskType.setPriority(DEFAULTPRIORITY);
            this.thread = new Thread();
            this.thread.setPriority(this.taskType.getPriorityValue());
            this.thread.start();
    }

    public Task(Callable<E> c, int priority) {
        if (priority > 0 && priority < 4)
        {
            this.taskType.setPriority(priority);
        } else {
            this.taskType.setPriority(DEFAULTPRIORITY);
        }
        this.thread = new Thread();
        this.thread.setPriority(this.taskType.getPriorityValue());
        this.thread.start();
    }

    public Task(Runnable r, int priority) {
        if (priority > 0 && priority < 4)
        {
            this.taskType.setPriority(priority);
        } else {
            this.taskType.setPriority(DEFAULTPRIORITY);
        }
        this.thread = new Thread(r);
        this.thread.setPriority(this.taskType.getPriorityValue());
        this.thread.start();
    }

    public Task(TaskType tp, Runnable r) {
        this.taskType = tp;
    }




//    public int compareTo(E o) {
//        this.c.compare((E)this.getClass(), (E) o.getClass());
//        return 0;
//    }

    public int getTaskPriority() {
        return this.taskType.getType().getPriorityValue();
    }
}
