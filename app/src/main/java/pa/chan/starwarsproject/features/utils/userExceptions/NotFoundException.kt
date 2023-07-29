package pa.chan.starwarsproject.features.utils.userExceptions

import pa.chan.starwarsproject.R

object NotFoundException: Throwable(), UserError {
    override val errorMessage: Int
        get() = R.string.Not_Found_Exception
    override val errorName: Int
        get() = R.string.Not_Found_Exception_name
    override val errorImg: Int?
        get() = null
}