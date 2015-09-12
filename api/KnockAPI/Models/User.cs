
namespace KnockAPI.Models
{
    public class User : Base
    {
        public long UserId { get; set; }
        public string Name { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public int Age { get; set; }
        public string Sex { get; set; }
        public string LocationKey { get; set; }
        public string Password { get; set; }
        public string ContactNo1 { get; set; }
        public string ContactNo2 { get; set; }
    }
}