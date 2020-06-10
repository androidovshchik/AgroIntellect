package ru.agrointellect.exception

class UnknownException(message: String?, cause: Throwable?) : Exception("Ошибка: $message")