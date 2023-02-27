import java.util.concurrent.Callable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


       /*     if (Runtime.getRuntime().availableProcessors() - 1 <= this.threadPoolExecutor.getActiveCount())
                    {

                    }*/ //TODO = use when executing the class.
public class CustomExecutor
{
    public PriorityBlockingQueue<Runnable> q = new PriorityBlockingQueue<>();
    public ThreadPoolExecutor threadPoolExecutor =
        new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() / 2, // Minimal Threads
                Runtime.getRuntime().availableProcessors() - 1, // Maximal Threads
                                       300, // Maximal idle time
                               TimeUnit.MILLISECONDS,
                                q); // PriorityBlockingQueue
    public static int maxPriority = 0; //TODO = remove priorities!
    private CustomExecutor()
    {

    }

        private void addTaskToQueue (Task t) // 1
        {
            this.q.add(t);
            this.getCurrentMax();
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    Task<Integer> t = new Task<>();
                }
            };
            Callable<Integer> v = new Callable() {
                @Override
                public Integer call() throws Exception {
                    return null;
                }
            };
            this.threadPoolExecutor.getQueue().add(r);

        }

        private void addTaskPlusTaskType (Task t, Integer priority) // 2
        {
            t.taskType.setPriority(priority);
            this.addTaskToQueue(t);
            this.getCurrentMax();

        }

  public int getCurrentMax()
  {
      maxPriority  = this.q.peek().getTaskPriority(); // TODO = make sure it's the right Task we check.
        return maxPriority;
  }
}
