package models

import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class CompteBancari {
    // Atributs
    protected var dataObertura: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyy-MM-dd"))
    protected var nomCompte: String = ""
    protected var saldo: Float = 0.0f

    // Constructors
    constructor()
    constructor(pDataObertura:String, pNomCompte:String, pSaldo:Float): this() {
        this.dataObertura = pDataObertura
        this.nomCompte = pNomCompte
        this.saldo = pSaldo
    }

    // Mètodes
    abstract fun ingressar()
    abstract fun consultarSaldo()
/*
    // Getters
    fun getDataObertura(): String {
        return this.dataObertura
    }
    fun getNomCompte(): String {
        return this.nomCompte
    }
    fun getSaldo(): Float {
        return this.saldo
    }

    // Setters
    fun setDataObertura(pDataObertura: String) {
        this.dataObertura = pDataObertura
    }
    fun setNomCompte(pNomCompte: String) {
        this.nomCompte = pNomCompte
    }
    fun setSaldo(pSaldo: Float) {
        this.saldo = pSaldo
    }
*/
    // toString
    override fun toString(): String {
        return "NOM DEL COMPTE:      ${this.nomCompte}\n" +
               "DATA D'OBERTURA:     ${this.dataObertura}\n" +
               "SALDO ACTUAL:        ${this.saldo}\n"
               // + super.toString()
    }
}