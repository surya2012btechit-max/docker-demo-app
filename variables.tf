variable "container_name" {
  description = "Name of the Docker container"
  type        = string
  default     = "terraform-nginx-tutorial"
}

variable "external_port" {
  description = "Port to expose NGINX on localhost"
  type        = number
  default     = 8095
}