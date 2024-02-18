package models

import utilities.readFloat
import utilities.readInt

class CompteCorrent: CompteBancari {
    // Atributs
    private var comisioManteniment: Float = 20.0f

    // Constructors
    constructor()
    constructor(pDataObertura:String, pNomCompte:String, pSaldo:Float, pComisioManteniment:Float = 20.0f): super() {
        super.dataObertura = pDataObertura
        super.nomCompte = pNomCompte
        super.saldo = pSaldo
        this.comisioManteniment = pComisioManteniment
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
    fun retirar() {
        val quantitat = readInt(pMessageIn = "Si us plau, introduïu la quantitat de diners que voleu retirar del vostre compte:",
            pMessageErrorDT = "La quantitat ha de ser un número positiu sense decimal.")
        if (super.saldo - quantitat < 0) {
            super.saldo -= quantitat + (quantitat * 0.10f)
            return println("QUANTITAT RETIRADA (AMB COMISSIÓ DE DESCOBERT):   ${quantitat}\n" +
                           "SALDO ACTUAL:                                     ${super.saldo}\n")
        } else {
            super.saldo -= quantitat
            return println("QUANTITAT RETIRADA:   ${quantitat}\n" +
                           "SALDO ACTUAL:         ${super.saldo}\n")
        }
    }
    fun cobrarComisio() {
        super.saldo -= this.comisioManteniment
        return println("COMISSIÓ DE MANTENIMENT:   ${this.comisioManteniment}\n" +
                       "SALDO ACTUAL:              ${super.saldo}")
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
    fun getComisioManteniment(): Float {
        return this.comisioManteniment
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
    fun setComisioManteniment(pComisioManteniment: Float) {
        this.comisioManteniment = pComisioManteniment
    }

    // toString
    override fun toString(): String {
        return "NOM DEL COMPTE:      ${this.nomCompte}\n" +
               "DATA D'OBERTURA:     ${this.dataObertura}\n" +
               "SALDO ACTUAL:        ${this.saldo}\n"
        // + super.toString()
    }
}