package mod.loader.script;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.scheduler.Task;
import cn.nukkit.scheduler.TaskHandler;
import mod.loader.Loader;

public class FunctionManager {

    private Loader plugin;

    public FunctionManager(Loader plugin){
        this.plugin = plugin;
    }

    public void createCommand(String name, String description, String functionName){
        plugin.getServer().getCommandMap().register(functionName, new EntryCommand(name, description, functionName));
    }

    public TaskHandler createTask(String functionName, int delay){
        return plugin.getServer().getScheduler().scheduleDelayedTask(new ModTask(functionName), delay);
    }

    public TaskHandler createLoopTask(String functionName, int delay){
        return plugin.getServer().getScheduler().scheduleDelayedRepeatingTask(new ModTask(functionName), 20, delay);
    }

    public void cancelTask(int id){
        plugin.getServer().getScheduler().cancelTask(id);
    }

    public String time(int seconds){
        int ss = seconds % 60;
        seconds /= 60;
        int min = seconds % 60;
        seconds /= 60;
        int hours = seconds % 24;
        return strzero(hours) + ":" + strzero(min) + ":" + strzero(ss);
    }

    public String format(String msg, Object... args){
        return String.format(msg, args);
    }

    private String strzero(int time){
        if(time < 10)
            return "0" + time;
        return String.valueOf(time);
    }

    public Loader plugin(){
        return plugin;
    }

    public class EntryCommand extends Command{

        private String functionName;

        public EntryCommand(String name, String description, String functionName) {
            super(name, description);
            this.functionName = functionName;
        }

        @Override
        public boolean execute(CommandSender sender, String s, String[] args) {
            plugin.callCommand(sender, args, functionName);
            return false;
        }
    }


    public class ModTask extends Task{

        private String functionName;

        public ModTask(String functionName){
            this.functionName = functionName;
        }

        @Override
        public void onRun(int i) {
            plugin.call(functionName, i);
        }
    }

}
