manager.createCommand("test", "oie", "test1");

function test1(s, args){
    if(args.length < 1){
        s.sendMessage('Sem argumentos!');
        return;
    }
    var name = args[0];
    s.sendMessage('test' + name);
}

function ServerCommandEvent(event){

}

