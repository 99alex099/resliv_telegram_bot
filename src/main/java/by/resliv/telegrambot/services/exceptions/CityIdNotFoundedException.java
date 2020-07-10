package by.resliv.telegrambot.services.exceptions;

public class CityIdNotFoundedException extends CityGeneralException {
    public CityIdNotFoundedException(Long invalidId) {
        super("City[id:" + invalidId + "] doesn't exist",
                invalidId.toString());
    }
}
