using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using NLog.Web;

namespace Library.API
{
    public class Program
    {
        public static void Main(string[] args)
        {
            BuildWebHost(args).Run();
        }

        public static IWebHost BuildWebHost(string[] args) =>
                 WebHost.CreateDefaultBuilder(args)
                     .UseStartup<Startup>()
                     .UseNLog()
                     .Build();
    }
}
