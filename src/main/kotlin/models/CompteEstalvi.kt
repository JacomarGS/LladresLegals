package models

import utilities.readFloat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CompteEstalvi: CompteBancari {
    // Atributs
    private var interessos: Float = super.saldo * 0.04f

    // Constructors
    constructor()
    constructor(pDataObertura:String, pNomCompte:String, pSaldo:Float, pInteressos:Float = 0.04f): super() {
        super.dataObertura = pDataObertura
        super.nomCompte = pNomCompte
        super.saldo = pSaldo
        this.interessos = pInteressos
    }

    // Mètodes
    override fun ingressar() {
        val quantitat = readFloat(pMessageIn = "Si us plau, introduïu la quantitat de diners que voleu ingressar al vostre compte:",
            pMessageErrorDT = "La quantitat ha de ser un nombre positiu i, si cal, amb decimal.")
        super.saldo += quantitat
        return println("QUANTITAT INGRESSADA:   ${quantitat}€\n" +
                "SALDO ACTUAL:           ${super.saldo}€\n")
    }
    override fun consultarSaldo() {
        return println("SALDO ACTUAL: ${super.saldo}€\n")
    }
    fun liquidar() {
        val penalitzacio = if (LocalDate.now().year - LocalDate.parse(dataObertura, DateTimeFormatter.ofPattern("dd-mm-yyyy")).year < 1) {
            val penalitzacioPercent = 0.03f
            val penalitzacioTotal = super.saldo * penalitzacioPercent
            super.saldo -= penalitzacioTotal
            println("PENALITZACIÓ PER LIQUIDACIÓ ABANS D'UN ANY:   ${penalitzacioTotal}\n" +
                    "SALDO ACTUAL:                                 ${super.saldo}\n")
        } else {
            0.0f
        }

        val totalLiquidat = super.saldo
        super.saldo = 0.0f

        println("LIQUIDACIÓ AMB PENALITZACIÓ:   ${penalitzacio}\n" +
                "SALDO LIQUIDAT:                ${totalLiquidat}\n")
    }

    // Getters
    fun getDataObertura(): String {
        return super.dataObertura
    }
    fun getNomCompte(): String {
        return super.nomCompte
    }
    fun getSaldo(): Float {
        return super.saldo
    }
    fun getInteressos(): Float {
        return this.interessos
    }

    // Setters
    fun setDataObertura(pDataObertura: String) {
        super.dataObertura = pDataObertura
    }
    fun setNomCompte(pNomCompte: String) {
        super.nomCompte = pNomCompte
    }
    fun setSaldo(pSaldo: Float) {
        super.saldo = pSaldo
    }
    fun setInteressos(pInteressos: Float) {
        this.interessos = pInteressos
    }

    // toString
    override fun toString(): String {
        return "NOM DEL COMPTE:      ${this.nomCompte}\n" +
               "DATA D'OBERTURA:     ${this.dataObertura}\n" +
               "SALDO ACTUAL:        ${this.saldo}\n"
        // + super.toString()
    }
}