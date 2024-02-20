package models

import interfices.ILiquidable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CarteraValors: ILiquidable {
    // Atributs
    private var nomCartera: String = ""
    private var nomEmpresa: String = ""
    private var quantitat: Int = 0
    private var valor: Float = 0.0f
    override var dataLiquidacio: String = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

    // Constructors
    constructor(pNomEmpresa: String, pQuantitat: Int, pValor: Float) {
        this.nomEmpresa = pNomEmpresa
        this.quantitat = pQuantitat
        this.valor = pValor
    }
    // Mètodes
    fun calcularValor(): Float {
        return this.quantitat * this.valor
    }

    fun consultarValor() {
        println("Valor actual de la cartera de valors de $nomEmpresa: ${calcularValor()}€")
    }

    override fun liquidar() {
        this.dataLiquidacio = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        println("Cartera de valors liquidada a data de ${this.dataLiquidacio}.\n" + "Import a rebre: ${calcularValor()}€")
    }

    // Getters
    fun getNomCartera(): String {
        return this.nomCartera
    }
    fun getNomEmpresa(): String {
        return this.nomEmpresa
    }
    fun getQuantitat(): Int {
        return this.quantitat
    }
    fun getValor(): Float {
        return this.valor
    }
    fun getDataLiquidacio(): String {
        return this.dataLiquidacio
    }

    // Setters
    fun setNomCartera(pNomCartera: String) {
        this.nomCartera = pNomCartera
    }
    fun setNomEmpresa(pNomEmpresa: String) {
        this.nomEmpresa = pNomEmpresa
    }
    fun setQuantitat(pQuantitat: Int) {
        this.quantitat
    }
    fun setValor(pValor: Float){
        this.valor = pValor
    }

    // toString
    override fun toString(): String {
        return "NOM DE LA CARTEDA DE VALORS: ${this.nomCartera}\n" + "NOM DE LA EMPRESA: ${this.nomEmpresa}\n" + "VALOR ACTUAL: ${this.valor}\n"
        // + super.toString()
    }
}