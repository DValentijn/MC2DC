# MC2DC
School project 

Just made or a school project that needed to be done in time




De plugin genaamd MC2DC oftewel Minecraft To Discord is gemaakt voor 1 reden. Het kunnen chatten met elkaar vanaf iemand die in de discord zit met iemand anders die in minecraft zit. Het enige wat de plugin doet is berichten die in discord gestuurd worden in de minecraft chat weergeven, en natuurlijk ook andersom. 

De plugin is gemaakt met de JDA (Java Discord API) om met de Discord-server te communiceren. Bij het enablen van de plugin wordt een JDA-bot online gezet met behulp van een Discord-bot token. Verder word er in de plugin ook een Discord-channel ID opgeslagen, deze is nodig om de bot te laten weten in welk kanaal hij het bericht moet sturen.

Zodra de bot online en verbonden is wordt een bericht ontvangen vanuit Discord via de ‘onMessageReceived’-methode. Deze methode controleert eerst of de afzender van het bericht geen bot is, om te voorkomen dat de bot reageert op andere bots. Vervolgens wordt het bericht doorgestuurd naar de Minecraft-server met behulp van de ‘sendToMinecraftServer’-methode.

De ‘sendToMinecraftServer’-methode verzendt het bericht naar de Minecraft-server. N de huidige implementatie wordt het bericht breed verspreid viade ‘Bukkit.broadcoast’-methode, met een prefix “[Discord]” om aan te geven dat het afkomstig is van Discord.

Om berichten van de Minecraft-server naar Discord te verzenden, is er de methode ‘toDiscord’ die wordt aangeroepen met een gebruikersnaam en een bericht. Deze methode zoekt het tekstkanaal op Discord op basis van het opgegeven kanaal-ID en stuurt het bericht daar naartoe.




