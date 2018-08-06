manager.createCommand("onetest", "onetest command", "testfunc");

function testfunc(sender, args){
    sender.sendMessage('I am TEST COMMAND!');
}

function PlayerJoinEvent(event){
    var player = event.getPlayer();
    player.sendMessage('Welcome to test PlayerJoinEvent');
}