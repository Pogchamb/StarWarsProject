package pa.chan.starwarsproject.features.utils.userExceptions

sealed interface UserError {
    val errorMessage: Int
    val errorName: Int
    val errorImg: Int?
}