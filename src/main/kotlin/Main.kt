
import kotlin.random.Random
import java.util.Scanner


fun checkEncounter(partySize: Int, location: Int, random : Int, night: Boolean): String {
    val randomNum = List(1) { Random.nextFloat() }
    val rand = randomNum[0]


    val enemyNum : Int = ((partySize * (1 + rand)).toInt())

    when (location) {
        1 -> {
            if (random <= 50)
                println("No Encounters")
            else {
                println("You encounter a group of ")
                println(enemyNum)
                println(" Orcs.")
            }
        }
        2 -> {
            if (!night) {

                when (random) {
                    in 1..25 -> {
                        println("No Encounters")
                    }
                    in 26..50 -> {
                        println("You encounter a group of ")
                        println(enemyNum)
                        println(" Orcs.")
                    }
                    in 51..75 -> {
                        println("You encounter a group of ")
                        println(enemyNum)
                        println(" goblins.")

                    }
                    in 76..100 -> {
                        println("You find ")
                        println(random * partySize)
                        println(" gold!")

                    }


                }
            } else {
                when (random) {
                    in 1..25 -> {
                        println("No Encounters")
                    }
                    in 26..50 -> {
                        println("You are ambushed by a group of ")
                        println(enemyNum)
                        println(" Orcs.")
                    }
                    in 51..75 -> {
                        println("You see a group of ")
                        println(enemyNum)
                        println(" ghosts.")

                    }
                    in 76..100 -> {
                        println("You find ")
                        println(random * partySize)
                        println(" gold!")

                    }


                }
            }

        }
        3 -> {
            if (random <= 50)
                println("No Encounters")
            else {
                println("You encounter a group of ")
                println(enemyNum)
                println(" Wolves.")
            }
        }
        4 -> {
            println("This is a bug, you're not on the map!")
        }
    }


    return " "

}

fun main() {
    var location = 1
    val quit = 9
    var night = false

    println("How many people are in the party?")
    val reader = Scanner(System.`in`)
    val partySize:Int = reader.nextInt()
    var input = 10

    while (input != quit)
    {
        println("You have left town, what will you do?")
        println("Hunt in the area(1)")
        println("Move to a random area(2)")
        println("Move to an adjacent area(3)")
        println("Go to a ruin(4)")
        println("Wander the area(5)")
        println("Wait where you are(6)")
        println("Rest here for the night(7)")
        println("Check your location on the map(8)")
        println("Return to town(9)")

        val read = Scanner(System.`in`)
        read.nextInt().also { input = it }
        val randomValue = List(1) { Random.nextInt(1, 101) }
        val random = randomValue[0]


        when (input) {
            1 -> {
                checkEncounter(partySize, location, random, night)
            }
            2 -> {
                val randomL = List(1) { Random.nextInt(1, 4) }
                val randL = randomL[0]
                location = randL
                checkEncounter(partySize, location, random, night)
            }
            3 -> {
                if(location != 3)
                    location += 1
                else
                    location -= 1
                checkEncounter(partySize, location, random, night)
            }
            4 -> {
                location = 2
                checkEncounter(partySize, location, random, night)
            }
            5 -> {
                checkEncounter(partySize, location, random, night)
            }
            6 -> {
                checkEncounter(partySize, location, random, night)
            }
            7 -> {
                night = true
                checkEncounter(partySize, location, random, night)
                night = false
            }
            8 -> {
                println(location)
            }
        }
    }

}

//private operator fun Int.plusAssign(function: () -> Any) {
//}


//private fun String.Companion.toInt(nextInt: Int): Any {
// return nextInt
//}

