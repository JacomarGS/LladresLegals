package models

import interfices.ILiquidable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CompteEstalvi: CompteBancari, ILiquidable {
    // Atributs
    private var interessos: Float = this.saldo * 0.04f
    override var dataLiquidacio: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    // Constructors
    constructor(pNomCompte:String, pSaldo:Float, pInteressos:Float) : super(pNomCompte, pSaldo) {
        super.nomCompte = pNomCompte
        super.saldo = pSaldo
        this.interessos = pInteressos
    }

    // Mètodes
    override fun ingressar(pQuantitat: Float) {
        this.saldo += pQuantitat
        return println("Total ingressat: ${pQuantitat}€\n" + "Saldo actual: ${this.saldo}€")
    }
    override fun consultarSaldo() {
        return println("Saldo actual: ${this.saldo}€\n")
    }
    override fun liquidar() {
        this.dataLiquidacio = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val penalitzacio = if (LocalDate.now().year - LocalDate.parse(dataObertura, DateTimeFormatter.ofPattern("yyyy-MM-dd")).year < 1) {
            val penalitzacioPercent = 0.03f
            val penalitzacioImport = this.saldo * penalitzacioPercent
            this.saldo -= penalitzacioImport
            penalitzacioImport
        } else {
            0.0f
        }

        val totalLiquidat = this.saldo
        this.saldo = 0.0f

        return println("Compte estalvi liquidat a data de ${this.dataLiquidacio}.\n" + "Penalització:   ${penalitzacio}€\n" + "Saldo liquidat: ${totalLiquidat}€\n")
    }

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
    fun getInteressos(): Float {
        return this.interessos
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