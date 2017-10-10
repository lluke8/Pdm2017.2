class Usuario(
        var nome:String,
        var rendaMensal:Double,
        var pontos:Corrupcao
){
    override fun toString(): String {
        return "Nome: ${this.nome}\nRenda Mensal: ${this.rendaMensal}"
    }
}

class Corrupcao(
        var tipo:Int
){


    override fun toString(): String {
        return "Corrupcao: ${tipo}"
    }
}

fun main(args: Array<String>) {
    var corrup1 = Corrupcao(1)
    var corrup2 = Corrupcao(2)
    var corrup3 = Corrupcao(3)
    var user1 = Usuario("joaozinho", 1000.0, corrup1)
    var user2 = Usuario("marcelinha", 2000.0, corrup2)
    var user3 = Usuario("amandinha", 3000.0, corrup2)
    var user4 = Usuario("marquinhos", 4000.0, corrup3)
    var user5 = Usuario("rafinha", 5000.0, corrup3)
    var usuarios = hashSetOf(user1, user2, user3, user4, user5)


    for (e in usuarios) {
        if (e.pontos.tipo.equals(1)) {
            println("${e}\nNIVEL: ${e.pontos.tipo} (Corrupcao basica!!)\n")
        } else if (e.pontos.tipo.equals(2)) {
            println("${e}\nNIVEL: ${e.pontos.tipo} (Corrupcao Media!!)\n")
        } else if(e.pontos.tipo.equals(3)) {
            println("${e}\nNIVEL: ${e.pontos.tipo} (Corrupcao Avancada!!)\n")
        }else{
            println("Tipo de corrupcao nao identificado!")
        }
    }
}