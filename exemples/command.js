manager.createCommand("name", "descricao do comando", "functiondele");
// o name = Nome do Comando, descrição do comando, functiondela é a função que será executada
// ao digitar o comando!

function functiondele(sender, args){
    if(args.lenght < 1){ // praticamente o isset do PHP
        sender.sendMessage('Você digitou incorretamente');
        return;
    }
    var name = args[0];
    sender.sendMessage("Você digitou: " + name); // formata para adicionar mensagens
    // sender.sendMessage(manager.format("Você digitou: %s", name)); outra forma de adicionar mensagens com {NAME}
}