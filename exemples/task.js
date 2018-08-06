manager.createTask("tasknormal", 20 * 20);
// tasknormal é a function, e 20 * 20 é o tempo = 20 segundos, será executado depois de 20 segundos
manager.createLoopTask("taskloop", 20 * 20); // tempo de 20 em 20 segundos será executado
// taskloop é a function

function tasknormal(currentTick){
    print('sou tasknormal!');
}

function taskloop(){
    print('sou taskloop');
}