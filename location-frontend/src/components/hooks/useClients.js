import { useQuery } from '@tanstack/react-query'
import axios from 'axios'

export default function useClients() {
    
    const getClientsData = ()=> axios.get('http://localhost:8080/clients/get-all').then(res => res.data)
    return useQuery({
        queryKey: ['clients'],
        queryFn: getClientsData,
        staleTime:10 * 1000,
        
})
}
