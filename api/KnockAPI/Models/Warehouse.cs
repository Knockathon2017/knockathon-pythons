
namespace KnockAPI.Models
{
    public class Warehouse : User
    {
        public long WarehouseId { get; set; }
        public long UserId { get; set; }
        public string Capacity { get; set; }
        public string Occupied { get; set; }
        public string Free { get; set; }
    }
}