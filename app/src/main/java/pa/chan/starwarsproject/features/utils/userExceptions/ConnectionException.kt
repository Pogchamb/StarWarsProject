package pa.chan.starwarsproject.features.utils.userExceptions

import pa.chan.starwarsproject.R

object ConnectionException: Throwable(), UserError {
    override val errorMessage: Int
        get() = R.string.Connection_Exception
    override val errorName: Int
        get() = R.string.Connection_Exception_name
    override val errorImg: Int
        get() = R.drawable.connection_error_svg
}