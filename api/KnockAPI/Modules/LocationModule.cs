using KnockAPI.Models.Context;
using Nancy;
using System;
using System.Configuration;
using System.IO;
using System.Net;
using System.Text;

namespace KnockAPI.Modules
{
    public class LocationModule : NancyModule
    {
        public LocationModule(IApplicationDbContext ctx)
        {
            string gdbServiceBase = ConfigurationManager.AppSettings["gdbServiceBase"].ToString();

            Get["/countries"] = _ =>
            {
                var _allCountries = new WebClient().DownloadString(string.Format("{0}{1}", gdbServiceBase, "countries"));
                return Response.AsJson<string>(_allCountries);
            };
            Get["/locations/{country}/{query}"] = _ =>
                {
                    string country = (string)_.country;
                    string query = (string)_.query;
                    var _allLocations = new WebClient().DownloadString(string.Format("{0}{1}/{2}?q={3}", gdbServiceBase, "suggest", country, query));
                    return Response.AsJson<string>(_allLocations);
                };

            Get["/location/{key}"] = _ =>
                {
                    var key = (string)_.key;
                    string URI = string.Format("{0}{1}", gdbServiceBase , "fetch");
                    string servicekeys = "{\"id\":[\"" + string.Join("\",\"", key) + "\"]}";
                    var http = (HttpWebRequest)WebRequest.Create(new  Uri(URI));
                    http.Accept = "application/json";
                    http.ContentType = "application/json";
                    http.Method = "POST";
                    ASCIIEncoding encoding = new ASCIIEncoding();
                    Byte[] bytes = encoding.GetBytes(servicekeys);
                    Stream reqStream = http.GetRequestStream();
                    reqStream.Write(bytes, 0, bytes.Length);
                    reqStream.Close();
                    var response = http.GetResponse();
                    var resStream = response.GetResponseStream();
                    var sr = new StreamReader(resStream);
                    var content = sr.ReadToEnd();
                    return content.ToString();

                };
                
        }
    }
}