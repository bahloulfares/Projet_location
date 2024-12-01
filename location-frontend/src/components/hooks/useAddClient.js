import { useMutation, useQueryClient } from "@tanstack/react-query";
import axios from "axios"

function useAddClient() {
    const queryClient = useQueryClient();

    const saveClient = (client) =>{
        axios.post("http://localhost:8080/clients/add",client)
        .then(res=>res.data)
      }
      const addClient = useMutation({
        mutationFn:saveClient,
        onMutate: (newClient)=>{
            const previousClients = queryClient.getQueriesData(["clients"]);
            queryClient.setQueryData(["clients"],clients=>[newClient,...clients]);
            return {previousClients}
        },
        onSuccess: (savedClient, newClient) => {
    
          queryClient.setQueryData(["clients"], clients =>
            clients.map(client => (client === newClient ? savedClient : client))
          );
        },
        
        onError: (error, newClient, context) => {
          if (!context) return;
          queryClient.setQueryData(["clients"], context.previousClients);
        
    
          const errorMessage = error.response?.data?.message || "Something went wrong. Please try again.";
          addClient.error = { message: errorMessage };
        }
        
      })
  return addClient
}

export default useAddClient