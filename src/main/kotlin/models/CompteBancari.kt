package models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class CompteBancari {
    // Atributs
    protected var dataObertura: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
    protected var nomCompte: String = ""
    protected var saldo: Float = 0.0f

    // Constructors
    constructor(pNomCompte: String, pSaldo: Float) {
        this.nomCompte = pNomCompte
        this.saldo = pSaldo
    }

    // Mètodes
    abstract fun ingressar(pQuantitat: Float)
    abstract fun consultarSaldo()

    // toString
    override fun toString(): String {
        return "NOM DEL COMPTE:   ${this.nomCompte}\n" +
               "DATA D'OBERTURA:  ${this.dataObertura}\n" +
               "SALDO ACTUAL:     ${this.saldo}\n"
               // + super.toString()
    }
}