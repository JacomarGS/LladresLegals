package models

import interfices.ILiquidable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CompteCorrent: CompteBancari, ILiquidable {
    // Atributs
    private var comisioManteniment: Float = 20.0f
    override var dataLiquidacio: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    // Constructors
    constructor(pNomCompte:String, pSaldo:Float, pComisioManteniment:Float): super(pNomCompte, pSaldo) {
        super.nomCompte = pNomCompte
        super.saldo = pSaldo
        this.comisioManteniment = pComisioManteniment
    }

    // Mètodes
    override fun ingressar(pQuantitat: Float) {
        this.saldo += pQuantitat
        println("Total ingressat: ${pQuantitat}€\n" + "Saldo actual: ${this.saldo}€")
    }
    override fun consultarSaldo() {
        return println("Saldo actual: ${this.saldo}€\n")
    }

    override fun liquidar() {
        this.dataLiquidacio = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val totalLiquidat = this.saldo
        this.saldo = 0.0f

        return println("Compte corrent liquidat a data de ${this.dataLiquidacio}.\n" + "Saldo liquidat: ${totalLiquidat}€\n")
    }
    fun retirar(quantitat: Float) {
        if (this.saldo >= quantitat) {
            this.saldo -= quantitat
            return println("Total retirat $quantitat€\n" + "Saldo actual: ${this.saldo}€")
        } else {
            return println("Fondos insuficientes en el compte ${this.nomCompte}.\n" + "Operació no realitzada.")
        }
    }
    fun cobrarComisio() {
        this.saldo -= this.comisioManteniment
        return println("Comissió de manteniment cobrada al compte ${this.nomCompte}.\n" +  "Saldo actual: ${this.saldo}€")
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
    fun getComisioManteniment(): Float {
        return this.comisioManteniment
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
    fun setComisioManteniment(pComisioManteniment: Float) {
        this.comisioManteniment = pComisioManteniment
    }

    // toString
    override fun toString(): String {
        return "NOM DEL COMPTE: ${this.nomCompte}\n" + "DATA D'OBERTURA: ${this.dataObertura}\n" + "SALDO ACTUAL: ${this.saldo}\n"
        // + super.toString()
    }
}