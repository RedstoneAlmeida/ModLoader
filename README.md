# ModLoader
Nukkit plugin, enable to load javascript! very simple create systems!!

# How to use?
- Create javascript archive, exemple: mod.js
- Drop archive in plugins/ModLoader/mod.js
- Create your code!
- Start your server! Instantly run

- Refs: https://github.com/RedstoneAlmeida/ModLoader/tree/master/exemples

# Basic JavaScript API loaded!
- Global Variables:
```javascript
var server; return getServer();
var plugin; return ModLoader Plugin MainClass;
var manager; return FunctionManager Class, Using to create Commands e Loops
var logger; return Console Logger Input
var players; return All Online Players
```

- Create Basic Command:
```javascript
manager.createCommand("name", "description", "functionUsed");


function functionUsed(sender, args){
    if(args.length < 1){ // see args exists
        sender.sendMessage('You used incorrect!');
        return;
    }
    var name = args[0];
    sender.sendMessage("You writer: " + name); // send Message to sender
    // sender.sendMessage(manager.format("You writer: %s", name)); format your message
}
```

- Create Basic Tasks:
```javascript
manager.createTask("tasknormal", 20 * 20);

manager.createLoopTask("taskloop", 20 * 20);

function tasknormal(currentTick){
    print('I tasknormal!');
}

function taskloop(currentTick){
    print('I taskloop');
}
```

- Run Events:
```javascript
function PlayerJoinEvent(event){
    var player = event.getPlayer();
    player.sendMessage("welcome to Server!");
}

// function BlockBreakEvent(event){}
// ready, start your server and test!
```

- Create Config
```javascript
var config = manager.createConfig(manager.getFile("folder", "archive"), 2); // 2 = Config.YAML

config.set("key", "value");
config.save();
```
