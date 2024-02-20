package controller

import interfices.ILiquidable
import models.CompteCorrent
import models.CompteEstalvi
import utilities.readSentence

fun main() {
    val llistaComptes = mutableListOf<ILiquidable>()

    do {
        println("\n--- Menú Principal ---")
        println("1. Crear un compte corrent")
        println("2. Crear un compte estalvi")
        println("3. Ingressar")
        println("4. Consultar saldo")
        println("5. Retirar diners d'un compte corrent")
        println("6. Liquidar un compte estalvi")
        println("0. Sortir de l'aplicació")

        print("Escull una opció: ")
        when (readLine()?.toInt() ?: 0) {
            1 -> {
                print("Introdueix el nom del compte corrent: ")
                val nomCompte = readSentence()
                val compteCorrent = CompteCorrent(nomCompte)
                llistaComptes.add(compteCorrent)
            }
            2 -> {
                print("Introdueix el nom del compte estalvi: ")
                val nomCompte = readLine() ?: ""
                val compteEstalvi = CompteEstalvi(nomCompte)
                llistaComptes.add(compteEstalvi)
            }
            3 -> {
                print("Introdueix l'índex del compte on vols ingressar: ")
                val index = readLine()?.toInt() ?: 0
                if (index >= 0 && index < llistaComptes.size) {
                    print("Introdueix la quantitat a ingressar: ")
                    val quantitat = readLine()?.toDouble() ?: 0.0
                    llistaComptes[index].ingressar(quantitat)
                } else {
                    println("Índex incorrecte.")
                }
            }
            4 -> {
                print("Introdueix l'índex del compte del qual vols consultar el saldo: ")
                val index = readLine()?.toInt() ?: 0
                if (index >= 0 && index < llistaComptes.size) {
                    llistaComptes[index].consultarSaldo()
                } else {
                    println("Índex incorrecte.")
                }
            }
            5 -> {
                print("Introdueix l'índex del compte corrent del qual vols retirar diners: ")
                val index = readLine()?.toInt() ?: 0
                if (index >= 0 && index < llistaComptes.size && llistaComptes[index] is CompteCorrent) {
                    print("Introdueix la quantitat a retirar: ")
                    val quantitat = readLine()?.toDouble() ?: 0.0
                    (llistaComptes[index] as CompteCorrent).retirar(quantitat)
                } else {
                    println("Índex incorrecte o el compte no és un compte corrent.")
                }
            }
            6 -> {
                print("Introdueix l'índex del compte estalvi que vols liquidar: ")
                val index = readLine()?.toInt() ?: 0
                if (index >= 0 && index < llistaComptes.size && llistaComptes[index] is CompteEstalvi) {
                    (llistaComptes[index] as CompteEstalvi).liquidar()
                } else {
                    println("Índex incorrecte o el compte no és un compte estalvi.")
                }
            }
            0 -> {
                println("Sortint de l'aplicació.")
            }
            else -> {
                println("Opció no vàlida.")
            }
        }
    } while (readLine() != "0")
}