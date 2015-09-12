
namespace KnockAPI.Models
{
    public class WorkProvider : User
    {
        public long Id { get; set; }
        public long UserId { get; set; }
        public int RequiredWorkforce { get; set; }
        
    }
}