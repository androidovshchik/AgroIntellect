package ru.agrointellect.exception

class WrongUidException(cause: Throwable?) : Exception("Неправильный логин/пароль")