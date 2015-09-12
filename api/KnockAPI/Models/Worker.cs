
namespace KnockAPI.Models
{
    public class Worker : User
    {
        public long Id { get; set; }
        public long UserId { get; set; }
        public bool? IsAvailable { get; set; }
    }
}