import api from './axios';

export const generateSentences = async (topic: string, level: string) => {
    const res = await api.post('/api/generateSentences', {
        topic,
        level
    })

    return res.data;
}