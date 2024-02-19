package interfices

import java.time.LocalDate
import java.time.format.DateTimeFormatter

interface ILiquidable {
    // Atributs
    var dataLiquidacio: String

    // Mètodes
    fun liquidar()

}