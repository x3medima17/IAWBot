public class SearchByAlbumHandler extends CommandHandler{
    public void before() {
        System.out.println("search by album name");
    }

    public void handle(Bot bot, Update update) {

        System.out.println("this is the search by name of the album");
        String msg=update.getMessage().getText().replaceFirst("/searchalbum","");
        System.out.println(msg);
        msg= msg.replaceAll(" ", "");
        if(!msg.isEmpty()) {
            LastfmAPI lastik = new LastfmAPI();
            try {
                String response = lastik.SearchForAlbum(msg);
                System.out.println(response);

                bot.sendMessage(update.getMessage().getChat().getId(), response);//+" "+response);
            } catch (Exception ex) {}
        }
    }

    public void after() {
        System.out.println("success?");
    }
}
